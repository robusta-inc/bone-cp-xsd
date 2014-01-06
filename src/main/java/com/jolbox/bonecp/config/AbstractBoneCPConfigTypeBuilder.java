package com.jolbox.bonecp.config;

import com.google.common.base.Predicate;
import com.jolbox.bonecp.xsd.DefaultConfigType;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.reflect.Modifier.isStatic;
import static java.lang.reflect.Modifier.isTransient;

public abstract class AbstractBoneCPConfigTypeBuilder<Type extends DefaultConfigType, Builder extends AbstractBoneCPConfigTypeBuilder<Type, Builder>> {

    private int minConnectionsPerPartition = 0;
    private int maxConnectionsPerPartition = 10;
    private int acquireIncrement = 2;
    private int partitionCount = 1;
    private int idleConnectionTestPeriodInMinutes = 240;
    private int idleConnectionTestPeriodInSeconds = 14400;
    private int idleMaxAgeInMinutes = 60;
    private int idleMaxAgeInSeconds = 3600;
    private int statementsCacheSize = 0;
    private boolean closeConnectionWatch = false;
    private boolean logStatementsEnabled = false;
    private int acquireRetryDelayInMs = 7000;
    private boolean lazyInit = false;
    private boolean transactionRecoveryEnabled = false;
    private int acquireRetryAttempts = 5;
    private boolean disableJMX = false;
    private int queryExecuteTimeLimitInMs = 0;
    private int poolAvailabilityThreshold = 0;
    private boolean disableConnectionTracking = false;
    private int connectionTimeoutInMs = 0;
    private int closeConnectionWatchTimeoutInMs = 0;
    private int maxConnectionAgeInSeconds = 0;
    private String serviceOrder = "FIFO";
    private boolean statisticsEnabled = false;
    private boolean defaultAutoCommit = true;
    private boolean defaultReadOnly = false;
    private boolean externalAuth = false;
    private boolean deregisterDriverOnClose = false;
    private boolean nullOnConnectionTimeout = false;
    private boolean resetConnectionOnClose = false;
    private boolean detectUnresolvedTransactions = false;
    private String poolStrategy = "DEFAULT";
    private boolean closeOpenStatements = false;
    private boolean detectUnclosedStatements = false;

    protected AbstractBoneCPConfigTypeBuilder() {}
    
    public Builder withDefaults() {
        return thisAsBuilder();
    }

    private Builder thisAsBuilder() {
        return (Builder) this;
    }

    public Builder withMinConnectionsPerPartition(int minConnectionsPerPartition) {
        this.minConnectionsPerPartition = minConnectionsPerPartition; return thisAsBuilder();
    }

    public Builder withMaxConnectionsPerPartition(int maxConnectionsPerPartition) {
        this.maxConnectionsPerPartition = maxConnectionsPerPartition; return thisAsBuilder();
    }

    public Builder withAcquireIncrement(int acquireIncrement) {
        this.acquireIncrement = acquireIncrement; return thisAsBuilder();
    }

    public Builder withPartitionCount(int partitionCount) {
        this.partitionCount = partitionCount; return thisAsBuilder();
    }

    public Builder withIdleConnectionTestPeriodInMinutes(int idleConnectionTestPeriodInMinutes) {
        this.idleConnectionTestPeriodInMinutes = idleConnectionTestPeriodInMinutes; return thisAsBuilder();
    }

    public Builder withIdleConnectionTestPeriodInSeconds(int idleConnectionTestPeriodInSeconds) {
        this.idleConnectionTestPeriodInSeconds = idleConnectionTestPeriodInSeconds; return thisAsBuilder();
    }

    public Builder withIdleMaxAgeInMinutes(int idleMaxAgeInMinutes) {
        this.idleMaxAgeInMinutes = idleMaxAgeInMinutes; return thisAsBuilder();
    }

    public Builder withIdleMaxAgeInSeconds(int idleMaxAgeInSeconds) {
        this.idleMaxAgeInSeconds = idleMaxAgeInSeconds; return thisAsBuilder();
    }

    public Builder withStatementsCacheSize(int statementsCacheSize) {
        this.statementsCacheSize = statementsCacheSize; return thisAsBuilder();
    }

    public Builder withCloseConnectionWatch(boolean closeConnectionWatch) {
        this.closeConnectionWatch = closeConnectionWatch; return thisAsBuilder();
    }

    public Builder withLogStatementsEnabled(boolean logStatementsEnabled) {
        this.logStatementsEnabled = logStatementsEnabled; return thisAsBuilder();
    }

    public Builder withAcquireRetryDelayInMs(int acquireRetryDelayInMs) {
        this.acquireRetryDelayInMs = acquireRetryDelayInMs; return thisAsBuilder();
    }

    public Builder withLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit; return thisAsBuilder();
    }

    public Builder withTransactionRecoveryEnabled(boolean transactionRecoveryEnabled) {
        this.transactionRecoveryEnabled = transactionRecoveryEnabled; return thisAsBuilder();
    }

    public Builder withAcquireRetryAttempts(int acquireRetryAttempts) {
        this.acquireRetryAttempts = acquireRetryAttempts; return thisAsBuilder();
    }

    public Builder withDisableJMX(boolean disableJMX) {
        this.disableJMX = disableJMX; return thisAsBuilder();
    }

    public Builder withQueryExecuteTimeLimitInMs(int queryExecuteTimeLimitInMs) {
        this.queryExecuteTimeLimitInMs = queryExecuteTimeLimitInMs; return thisAsBuilder();
    }

    public Builder withPoolAvailabilityThreshold(int poolAvailabilityThreshold) {
        this.poolAvailabilityThreshold = poolAvailabilityThreshold; return thisAsBuilder();
    }

    public Builder withDisableConnectionTracking(boolean disableConnectionTracking) {
        this.disableConnectionTracking = disableConnectionTracking; return thisAsBuilder();
    }

    public Builder withConnectionTimeoutInMs(int connectionTimeoutInMs) {
        this.connectionTimeoutInMs = connectionTimeoutInMs; return thisAsBuilder();
    }

    public Builder withCloseConnectionWatchTimeoutInMs(int closeConnectionWatchTimeoutInMs) {
        this.closeConnectionWatchTimeoutInMs = closeConnectionWatchTimeoutInMs; return thisAsBuilder();
    }

    public Builder withMaxConnectionAgeInSeconds(int maxConnectionAgeInSeconds) {
        this.maxConnectionAgeInSeconds = maxConnectionAgeInSeconds; return thisAsBuilder();
    }

    public Builder withServiceOrder(String serviceOrder) {
        this.serviceOrder = serviceOrder; return thisAsBuilder();
    }

    public Builder withStatisticsEnabled(boolean statisticsEnabled) {
        this.statisticsEnabled = statisticsEnabled; return thisAsBuilder();
    }

    public Builder withDefaultAutoCommit(boolean defaultAutoCommit) {
        this.defaultAutoCommit = defaultAutoCommit; return thisAsBuilder();
    }

    public Builder withDefaultReadOnly(boolean defaultReadOnly) {
        this.defaultReadOnly = defaultReadOnly; return thisAsBuilder();
    }

    public Builder withExternalAuth(boolean externalAuth) {
        this.externalAuth = externalAuth; return thisAsBuilder();
    }

    public Builder withDeregisterDriverOnClose(boolean deregisterDriverOnClose) {
        this.deregisterDriverOnClose = deregisterDriverOnClose; return thisAsBuilder();
    }

    public Builder withNullOnConnectionTimeout(boolean nullOnConnectionTimeout) {
        this.nullOnConnectionTimeout = nullOnConnectionTimeout; return thisAsBuilder();
    }

    public Builder withResetConnectionOnClose(boolean resetConnectionOnClose) {
        this.resetConnectionOnClose = resetConnectionOnClose; return thisAsBuilder();
    }

    public Builder withDetectUnresolvedTransactions(boolean detectUnresolvedTransactions) {
        this.detectUnresolvedTransactions = detectUnresolvedTransactions; return thisAsBuilder();
    }

    public Builder withPoolStrategy(String poolStrategy) {
        this.poolStrategy = poolStrategy; return thisAsBuilder();
    }

    public Builder withCloseOpenStatements(boolean closeOpenStatements) {
        this.closeOpenStatements = closeOpenStatements; return thisAsBuilder();
    }

    public Builder withDetectUnclosedStatements(boolean detectUnclosedStatements) {
        this.detectUnclosedStatements = detectUnclosedStatements; return thisAsBuilder();
    }

    public abstract Type build();

    protected List<Field> declaredFields() {
        List<Field> fields = newArrayList();
        Class current = this.getClass();
        while (!current.equals(Object.class)) {
            fields.addAll(filter(newArrayList(current.getDeclaredFields()), new Predicate<Field>() {
                @Override
                public boolean apply(Field input) {
                    return !isStatic(input.getModifiers()) && !isTransient(input.getModifiers());
                }
            }));
            current = current.getSuperclass();
        }
        return fields;
    }
}
