//package com.sof306.service;
//
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.sof306.dao.AccountsDAO;
//import com.sof306.dao.AuthorityDAO;
//import com.sof306.entity.Accounts;
//import com.sof306.entity.Authorities;
//
//
//@Service
//public class AccountService  implements UserDetailsService{
//	@Autowired
//	AccountsDAO accountDao;
//
//	@Autowired
//	AuthorityDAO authorityDAO;
//
//	@Autowired
//	BCryptPasswordEncoder pe;
//
//	public Optional<Accounts> getAccount(String username){
//		return accountDao.findById(username);
//	}
//
//	public List<String> getRolesByUsername(String username){
//
//		List<String> roleNames = new ArrayList<>();
//
//		List<Authorities> authorities = authorityDAO.findAll();
//
//		for (Authorities authority : authorities) {
//			if(authority.getAccount().getAccountId().equals(username)){
//				roleNames.add(authority.getRole().getId());
//			}
//		}
//		return roleNames;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		try {
//			Accounts account = accountDao.findById(username).get();
//			// Tạo UserDetails từ Account
//			String password = account.getPassword();
//			String[] roles = account.getAuthority().stream()
//				.map(au -> au.getRole().getId())
//				.collect(Collectors.toList()).toArray(new String[0]);
//
//
//	
//				Map<String, Object> authentication = new HashMap<>();
//				authentication.put("user", account);
//				byte[] token = (username + ":" + account.getPassword()).getBytes();
//				authentication.put("token", "Basic " + Base64.getEncoder().encodeToString(token));
//				//session.setAttribute("authentication", authentication);
//				
//				
//			return User.withUsername(username)
//					.password(pe.encode(password))
//					.roles(roles).build();
//		} catch (Exception e) {
//			throw new UsernameNotFoundException(username + " not found!");
//		}
//	}
//	
//	// public void loginFromOAuth2(OAuth2AuthenticationToken oauth2){
//	// 	// String fullname = oauth2.getPrincipal().getAttribute("name");
//	// 	String email = oauth2.getPrincipal().getAttribute("email");
//	// 	String password = Long.toHexString(System.currentTimeMillis());
//		
//	// 	UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("GUEST").build();
//	// 	Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//	// 	SecurityContextHolder.getContext().setAuthentication(auth);
//	// 	this.setToken(email, password);
//	// }
//	
//	// @Autowired
//	// HttpSession session;
//	
//	// public void setToken(String username, String password) {
//	// 	byte[] auth = (username + ":" + password).getBytes();
//	// 	String token = "Basic " + Base64.getEncoder().encodeToString(auth);
//	// 	session.setAttribute("token", token);
//	// }
//	
//	// public String getToken() {
//	// 	return (String) session.getAttribute("token");
//	// }
//}