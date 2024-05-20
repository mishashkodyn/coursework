public class Client {
    private String name;
    private String surname;
    private String identificationCode;

    public Client(String name, String surname, String identificationCode) {
        this.name = name;
        this.surname = surname;
        this.identificationCode = identificationCode;
    }

    public void printInfo() {
        System.out.println("Ім'я: " + getName());
        System.out.println("Прізвище: " + getSurname());
        System.out.println("Інденфікаційний код: " + getIdentificationCode());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }
}
