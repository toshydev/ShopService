package click.snekhome;

import java.util.Map;

public abstract class Repo {

    public abstract Object get(int id);

    public abstract void add(Object obj);

    public abstract void remove(int id);
}
