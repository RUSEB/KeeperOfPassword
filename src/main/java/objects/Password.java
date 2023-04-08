package objects;

public class Password {

	private String name;
	private String login;
	private String password;
	private String dateUpdate;
	private String siteLink;
	
	
	private Password() {
		
	};
	
	public Password(String name,String login,String password,String dateUpdate,String siteLink) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.dateUpdate = dateUpdate;
		this.siteLink = siteLink;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getSiteLink() {
		return siteLink;
	}

	public void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
	}
	
}
