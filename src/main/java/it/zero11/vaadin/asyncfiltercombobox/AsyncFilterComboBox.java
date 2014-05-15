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

package it.zero11.vaadin.asyncfiltercombobox;

import it.zero11.vaadin.asyncfiltercombobox.client.AsyncFilterComboBoxConstants;

import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.ui.ComboBox;

public class AsyncFilterComboBox extends ComboBox {
	private static final long serialVersionUID = 1L;
	
	private FilterChangeEventMode filterChangeEventMode = FilterChangeEventMode.LAZY;
	private int filterChangeEventTimeout = 500;
	
    public void setFilterChangeEventMode(FilterChangeEventMode inputEventMode) {
        filterChangeEventMode = inputEventMode;
        markAsDirty();
    }

    public FilterChangeEventMode getFilterChangeEventMode() {
        return filterChangeEventMode;
    }

    public enum FilterChangeEventMode {
        EAGER,
        LAZY
    }
    
    public void setFilterChangeTimeout(int timeout) {
        filterChangeEventTimeout = timeout;
        markAsDirty();
    }

    public int getFilterChangeTimeout() {
        return filterChangeEventTimeout;
    }
    
    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        target.addAttribute(AsyncFilterComboBoxConstants.ATTR_FILTERCHANGE_EVENTMODE,
                    getFilterChangeEventMode().toString());
        target.addAttribute(AsyncFilterComboBoxConstants.ATTR_FILTERCHANGE_TIMEOUT,
        		getFilterChangeTimeout());
            
        super.paintContent(target);
    }
}
