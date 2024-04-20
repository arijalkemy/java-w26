package interfaces;

public interface ICrudRepository<T, COLLECTION_RETURN> extends IRemove<T>, IAdd<T>, IAddAll<T>, IGet<T>, IGetAll<COLLECTION_RETURN> {
    
}

