package springboot.vaadintest.Vaadindemo;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import springboot.spring.entity.EmployeeEntity;
import springboot.spring.services.Departmentservice;
import springboot.spring.services.Employeeservice;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private Departmentservice dservice;
	
	@Autowired
	private Employeeservice eservice;
	
	@Autowired
	private Grid<EmployeeEntity> grid=new Grid<>(EmployeeEntity.class);
	
	@Override 
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
     // add Grid to the layout
        layout.addComponents(grid);
        grid.setColumns("employeeid", "employeename");
        
        setContent(layout);
    }
	
	public void updateList() {
	    // fetch list of Customers from service and assign it to Grid
		List<EmployeeEntity> employees = eservice.getEmployee();
        grid.setItems(employees);
	}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
