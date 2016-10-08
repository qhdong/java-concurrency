package chap02;

/**
 * 延迟初始化导致竞争
 */
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }

        return instance;
    }
}

class ExpensiveObject {

}
