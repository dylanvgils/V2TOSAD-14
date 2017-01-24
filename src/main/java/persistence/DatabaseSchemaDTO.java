package persistence;

public class DatabaseSchemaDTO {
    private String name;

    public DatabaseSchemaDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
