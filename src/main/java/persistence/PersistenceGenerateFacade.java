package persistence;


import persistence.generate.GeneratorDAO;
import persistence.generate.GeneratorImpl;

public class PersistenceGenerateFacade {
    private static final GeneratorDAO generator = new GeneratorImpl();

    public static boolean executeQuery(String sql) {
        return generator.executeQuery(sql);
    }
}
