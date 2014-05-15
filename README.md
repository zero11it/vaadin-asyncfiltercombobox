# AsyncFilterComboBox Add-on for Vaadin 7

AsyncFilterComboBox is an extended version of Vaadin ComboBox which allows to change the way
filtering is triggered (like with setTextChangeEventMode on TextField).

## Download release (cooming soon)

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to http://vaadin.com/addon/asyncfiltercombobox

## Release notes

### Version 0.1.0
- First Public Release

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:
- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

AsyncFilterComboBox is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

AsyncFilterComboBox is written by Zero11

# Developer Guide

## Getting started

Here is a simple example on how to try out the add-on component:

Add widgetset dependency:

```xml
<inherits name="it.zero11.vaadin.asyncfiltercombobox.WidgetSet" /> 
```

Use AsyncFilterComboBox like built-in ComboBox (the default behaviour include 500ms delay).

To Change the delay call:
```
asyncfilterComboBox.setFilterChangeTimeout(2000);
```
To Revert the behaviour to built-in ComboBox:
```
asyncfilterComboBox.setFilterChangeEventMode(FilterChangeEventMode.EAGER);
```
