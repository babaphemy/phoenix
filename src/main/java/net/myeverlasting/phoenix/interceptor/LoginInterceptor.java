package net.myeverlasting.phoenix.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.service.UsersServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UsersServ usersServ;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		if(user == null){
			Authentication authe = SecurityContextHolder.getContext().getAuthentication();
			String email = authe.getName();
			user = usersServ.findByEmail(email);
			session.setAttribute("user", user);
		}
		return super.preHandle(request, response, handler);
		
	}

}
