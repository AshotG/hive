package org.apache.hadoop.hive.metastore;

import org.apache.hadoop.conf.Configuration;

public interface IMetastoreDBConfigurationReader {
    Configuration readConfiguration(String workspaceName, Configuration defaultConfiguration);
}
