package org.apache.hadoop.hive.metastore.mocks;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.metastore.IMetastoreDBConfigurationReader;

public class MockMetastoreDBConfigurationReader implements IMetastoreDBConfigurationReader {
    @Override
    public Configuration readConfiguration(String workspaceName, Configuration defaultConfiguration) {
        if (defaultConfiguration == null) {
            throw new RuntimeException("defaultConfiguration parameter cannot be null.");
        }

        switch (workspaceName)
        {
        case "test_workspace": {
            // Clone, replace parameters and return.
            Configuration result = new Configuration(defaultConfiguration);

            result.set("javax.jdo.option.ConnectionDriverName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            result.set("javax.jdo.option.ConnectionURL", "jdbc:sqlserver://ashot:1433;database=HMS;");
            result.set("javax.jdo.option.ConnectionUserName", "hms");
            result.set("javax.jdo.option.ConnectionPassword", "hms");

            return result;
        }

        case "test_workspace_wont_work": {
            // Clone, replace parameters and return.
            Configuration result = new Configuration(defaultConfiguration);

            result.set("javax.jdo.option.ConnectionDriverName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            result.set("javax.jdo.option.ConnectionURL", "jdbc:sqlserver://random:1433;database=RANDOM;");
            result.set("javax.jdo.option.ConnectionUserName", "someone");
            result.set("javax.jdo.option.ConnectionPassword", "something");

            return result;
        }

        default:
            return defaultConfiguration;
        }
    }
}
