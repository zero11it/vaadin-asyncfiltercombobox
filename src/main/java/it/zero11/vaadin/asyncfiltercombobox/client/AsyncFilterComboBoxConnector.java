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

import it.zero11.vaadin.asyncfiltercombobox.AsyncFilterComboBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.combobox.ComboBoxConnector;
import com.vaadin.shared.ui.Connect;

@Connect(AsyncFilterComboBox.class)
public class AsyncFilterComboBoxConnector extends ComboBoxConnector {
	private static final long serialVersionUID = 1L;

	@Override
	protected Widget createWidget() {
		return GWT.create(AsyncFilterComboBoxWidget.class);
	}

	@Override
	public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
		getWidget().filterChangeEventMode = uidl
				.getStringAttribute(AsyncFilterComboBoxConstants.ATTR_FILTERCHANGE_EVENTMODE);
		getWidget().filterChangeEventTimeout = uidl
				.getIntAttribute(AsyncFilterComboBoxConstants.ATTR_FILTERCHANGE_TIMEOUT);
		super.updateFromUIDL(uidl, client);
	}

	@Override
	public AsyncFilterComboBoxWidget getWidget() {
		return (AsyncFilterComboBoxWidget) super.getWidget();
	}
}
