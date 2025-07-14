package org.shenefelt;

public class User
{
    private String username;
    private String password;
    private int altID;

    public User() { }


    public User(String user, String pass, int altPIN)
    {
        username = user;
        password = pass;
        altID = altPIN;
    }
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getAltID()
    {
        return altID;
    }

    public void setAltID(int altID)
    {
        this.altID = altID;
    }

    @Override
    public String toString()
    {
        return "username: " + username + "\npassword: " + password + "\nALT ID: " + altID +"\n ----------";
    }
}
