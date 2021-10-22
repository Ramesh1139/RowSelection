package bean;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class RowSelection {
    public RowSelection() {
    }

    public void selectAllCheckBoxVCL(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        try {
            System.out.println("xdebug c1 : In selectAllChoiceBoxLN with value = "+
            valueChangeEvent.getNewValue());

            boolean isSelected = ((Boolean)valueChangeEvent.getNewValue()).booleanValue();
            DCBindingContainer binding = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding iterator = binding.findIteratorBinding("StudentVO1Iterator");
            ViewObject vo = iterator.getViewObject();
            
            int i = 0;
            Row row = null;
            vo.reset();
            while (vo.hasNext())
            {
                if (i == 0)
                    row = vo.first();
                else
                    row = vo.next();            

    
                if(isSelected)
                  row.setAttribute("Status", "Y");
                else
                 row.setAttribute("Status", "N");
                i++;
            }   
        } catch (Exception e) {
            // TODO: Add catch code
            System.out.println(e.toString());
        }
    }
}
