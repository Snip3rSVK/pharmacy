package App.Db;

import java.util.Set;

public abstract class AbstractDatabase<E> {

    public abstract Set<E> getAll();

}
