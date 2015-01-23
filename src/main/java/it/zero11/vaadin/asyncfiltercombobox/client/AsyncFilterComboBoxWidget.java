/**
 * Copyright (C) 2014 Zero11 S.r.l.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.zero11.vaadin.asyncfiltercombobox.client;

import com.google.gwt.user.client.Timer;
import com.vaadin.client.ui.VFilterSelect;

public class AsyncFilterComboBoxWidget extends VFilterSelect{
	private static final String FILTERCHANGE_MODE_LAZY = "LAZY";
	
	public String filterChangeEventMode = FILTERCHANGE_MODE_LAZY;
	public int filterChangeEventTimeout = 500;

    private boolean scheduled = false;
    private int queuedPage = 0;
	private String queuedFilter = null;

	private Timer filterChangeEventTrigger = new Timer(){
		@Override
		public void run(){
			if (isAttached()){
				superFilterOptions();
				scheduled = false;
			}
		}
	};
	
	public void filterOptions(int page) {
		if (filterChangeEventMode.equals(FILTERCHANGE_MODE_LAZY)){
			queuedPage = page;
			queuedFilter = null;
			scheduleFilterOption();
		}else{
			super.filterOptions(page, tb.getText());
		}
	}

	public void filterOptions(int page, String filter) {
		if (scheduled){
			filterChangeEventTrigger.cancel();
			if (filter.equals(lastFilter) && !filter.equals(tb.getText())){
				filter = tb.getText();
			}
		}
		
		super.filterOptions(page, filter);
	}
	
	public void scheduleFilterOption(){
		if (scheduled)
			filterChangeEventTrigger.cancel();
		filterChangeEventTrigger.schedule(filterChangeEventTimeout);
		scheduled = true;
	}
	
	private void superFilterOptions(){
		if (queuedFilter == null)
			super.filterOptions(queuedPage, tb.getText());
		else
			super.filterOptions(queuedPage, queuedFilter);
	}
}