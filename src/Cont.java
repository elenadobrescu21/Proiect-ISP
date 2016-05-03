public class Cont {

    private String username;
    private String parola;

    // CONSTRUCTOR

    public Cont(String username, String parola) {
	this.username = username;
	this.parola = parola;
    }

    // SETTERI

    public void setParola(String parola) {
	this.parola = parola;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    // GETTERI

    public String getParola() {
	return parola;
    }

    public String getUsername() {
	return username;
    }

    // FUNCTII UTILITARE

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((parola == null) ? 0 : parola.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Cont other = (Cont) obj;
	if (parola == null) {
	    if (other.parola != null)
		return false;
	} else if (!parola.equals(other.parola))
	    return false;
	if (username == null) {
	    if (other.username != null)
		return false;
	} else if (!username.equals(other.username))
	    return false;
	return true;
    }

}
