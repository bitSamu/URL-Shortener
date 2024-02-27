import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.StartupEvent;

/**
 * Initialized a database schema in case of a local DB test
 */
@ApplicationScoped
public class DBInitializer {

    @Inject
    @ConfigProperty(name = "url-shortener.schema.create", defaultValue = "false")
    boolean schemaCreate;

    @Inject
    DataSource dataSource;

    void onStart(@Observes StartupEvent ev) {

        if (schemaCreate)
            initdb();
    }

    private void initdb() {

        System.out.println("Init DB");

        try (Connection connection = dataSource.getConnection()) {

            try (Statement stmt = connection.createStatement()) {

                stmt.execute("DROP TABLE IF EXISTS url_shortener_db");

                stmt.execute("CREATE TABLE url_shortener_db (" +
                        "id SERIAL PRIMARY KEY, " +
                        "short_url VARCHAR(255), " +
                        "original_url TEXT)");

                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM url_shortener_db");

                rs.next();

                System.out.println("Table contains " + rs.getInt("rowcount") + " rows");

            } catch (SQLException e) {
                System.out.println("Error processing statement " + e);
            }

        } catch (SQLException e) {
            System.out.println("Error processing connection " + e);
        }
    }

}