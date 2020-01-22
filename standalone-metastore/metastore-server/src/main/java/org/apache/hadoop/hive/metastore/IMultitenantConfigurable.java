package org.apache.hadoop.hive.metastore;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;

public interface IMultitenantConfigurable extends Configurable {
    Configuration getConf(String workspaceName);
}
