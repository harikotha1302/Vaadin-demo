package springboot.spring.ui;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import springboot.spring.entity.EmployeeEntity;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@SpringUI
public class MyUI extends UI {
	private static final long serialVersionUID = 1L;


	RestTemplate service=new RestTemplate();
	
	Grid<EmployeeEntity> grid=new Grid<>(EmployeeEntity.class);
	TextField textfield=new TextField();
	
	
	@Override 
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        textfield.setPlaceholder("Serch by id");
        textfield.addValueChangeListener(e -> employeesearch(textfield.getValue()));
        textfield.setValueChangeMode(ValueChangeMode.LAZY);
        Button clearFilterTextBtn = new Button(VaadinIcons.CLOSE);
        clearFilterTextBtn.setDescription("Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> textfield.clear());
        CssLayout filtering = new CssLayout();
        filtering.addComponents(textfield, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        
        grid.setColumns("employeeid","employeename");
        layout.addComponents(filtering, grid);
        setContent(layout);
    }
	
	private void employeedata(){
		List<EmployeeEntity> ls=new ArrayList<EmployeeEntity>();
		final String uri = "http://localhost:8087/employee";
		ResponseEntity<List<EmployeeEntity>> employeeResponse =
		        service.exchange(uri,
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeEntity>>() {
		            });
		ls=employeeResponse.getBody();
		grid.setItems(ls);
	}
	
	private void employeesearch(String id)
	{
		final String uri = "http://localhost:8087/employee/{id}";
		Map<String,String> m=new HashMap<>();
		m.put("id", id);
		URI url = UriComponentsBuilder.fromUriString(uri)
	        .buildAndExpand(m)
	        .toUri();
		ResponseEntity<EmployeeEntity> employeeResponse =
	        service.exchange(url,
	                    HttpMethod.GET, null,EmployeeEntity.class);
		;
		System.out.println(employeeResponse.getBody());
		grid.setItems(employeeResponse.getBody());
		
	}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = true)
    public static class MyUIServlet extends VaadinServlet {
    }
}
