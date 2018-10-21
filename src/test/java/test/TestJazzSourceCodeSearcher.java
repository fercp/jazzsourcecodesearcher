package test;

import com.fercp.jazz.sourcecode.searcher.connection.JazzConnection;
import org.junit.After;
import org.junit.Before;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 08.11.2012 13:30
 * @see
 */
public class TestJazzSourceCodeSearcher {
    JazzConnection connection;

    @Before
    public void startUp() {
        String user = "";
        String password = "";
        String repositoryAddress = "";
        connection = new JazzConnection(user, password, repositoryAddress);
    }

    @After
    public void closeConnection() {
        connection.close();
    }
}

