package io.jojun.gof;

import java.io.Serializable;

public class Settings implements Serializable {
    //For Singleton Pattern

    /*
    2. Eager Initialization
    private static final Settings INSTANCE = new Settings();
    */
    /*
    3. Double Checked Locking
    private static volatile Settings instance;
    */

    // 클래스 밖에서 생성자를 사용할 수 없게 private 생성자를 선언
    private Settings() {
    }

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    //Global 한 접근을 위해 static 선언
    //멀티 쓰레드 환경에서는 Thread Safe 하지 않음.
    // -> 1. getInstance 메쏘드에 synchronized 블럭 사용, 단점은 매번 getInstance를 호출 할 때 synchronized를 호출
    // -> 2. 이른 초기화 (eager initialization) 사용, 단점 미리 만드는 과정이 메모리를 많이 사용하는데 실제 사용하지 않는 경우
    // -> 3. double checked locking 사용, 인스턴스를 필요로 하는 시점에 생성할 수 있고, 매번 synchronized를 호출 하지 않음. 다만 volatile 의 동작이나 synchronized의 동작을 이해해야 함.
    // -> 4. static inner class 사용, 권장하는 방법 중 하나
    public static Settings getInstance() {
       /*
       // 다른 쓰레드가 근 시점 차에 접근 했을 때 두 개의 인스턴스가 생성될 수 있음.
       if (instance == null) {
           instance = new Settings();
       }
       return instacne;
       */

        /*
        // 3.Double Checked Locking
        if (instance == null) {
            synchronized (Settings.class) {
                if (instance == null) {
                    instance = new Settings();
                }
            }
        }
        return instance;
        */

        //04. static inner
        return SettingsHolder.INSTANCE;
    }

    /*
    싱글톤을 깨트리는 방법 (어떻게 사용하는지에 따라 깨질 수 있다.)
        01. 사용할 때 리플렉션을 사용 할 경우 싱글턴 패턴이 깨질 수 있다. - 대응 방법이 없음. -> enum을 사용하면 방어할 수는 있다. -> enum은 리플렉션에서 newInstance를 할 수 없게끔 막아놨다.
        -> enum은 클래스를 로딩 하는 순간 만들어지기 때문에 단점이 될 수도 있다. 또한 상속을 쓰지 못한다는것이 단점. enum은 enum만 상속 받을 수 있다.
        02. 직렬화와 역직렬화를 사용, 역직렬화를 할 때 인스턴스를 새로 생성하기 때문에. -> 대응방안으로는 *1

    */

    /*
    //*1. 역직렬화 대처 방안. 아래의 시그니쳐를 가지고 있으면 정의한 메쏘드를 호출한다.
    protected Object readResolve() {
        return getInstance();
    }
    */

    /*
    enum 은 시리얼라이저블을 구현하고 있기 때문에 직렬화 역직렬화에 safe하다.
     */

    /*
     최종적으로 싱글톤 패턴을 구현할 때는 enum 또는 static inner class 방법으로 구현하는 것을 권장한다.
     */
}
