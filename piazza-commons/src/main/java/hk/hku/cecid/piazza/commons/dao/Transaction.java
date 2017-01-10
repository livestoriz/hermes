package hk.hku.cecid.piazza.commons.dao;


/**
 * The Transaction interface allows operations to be performed against the 
 * transaction in the target Transaction object. A Transaction object is created
 * by a corresponding DAO factory. Before any transaction starts, the Transaction
 * object should be notified by the invocation of its begin() method. When the 
 * transaction is finished, either commit() or rollback should be invoked and 
 * the resources it acquired should be released accordingly.
 * 
 * @author Hugo Y. K. Lam
 *
 */
public interface Transaction {

    /**
     * Begins the transaction.
     * 
     * @throws DAOException if unable to begin the transaction.
     */
    public void begin() throws DAOException;
    
    /**
     * Commits the transaction.
     * 
     * @throws DAOException if unable to commit the transaction. 
     */
    public void commit() throws DAOException;
    
    /**
     * Rolls back the transaction.
     * 
     * @throws DAOException unable to roll back the transaction.
     */
    public void rollback() throws DAOException;
}
