package proto.rest.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proto.business.model.Place;
import proto.business.service.ITestService;

/**
 * REST controller for test service access
 * 
 * @author ecaillat
 *
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

	/**
	 * The test services
	 */
	@Resource
	private ITestService testServices;

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * REST listener for GET method on root URL
	 * 
	 * @param arg
	 *            an argument
	 * @return a place
	 */
	@RequestMapping(value = "/{arg}", method = RequestMethod.GET)
	public Place get(@PathVariable(value = "arg") String arg) {
		return testServices.foo(arg);
	}

	/**
	 * REST listener for POST method on root URL
	 * 
	 * @param place
	 *            a place
	 * @return the place name
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String post(@RequestBody Place place) {
		jmsTemplate.convertAndSend("post_place", place);
		return place.getName();
	}
}
