package kr.sagyeradio.util;

public class Reference {
    public static final String MOD_ID = "olivemodradio";
    public static final String MOD_NAME = "OliveModRadio";
    public static final String VERSION = "0.1";
    public static final String Client_Side = "kr.sagyeradio.proxy.ClientProxy";
    public static final String Server_Side = "kr.sagyeradio.proxy.CommonProxy";


    private static class InnerInstanceGameVariableClazz {
        private static final Reference uniqueGameVariable = new Reference();
    }

    public static Reference Instance() {
        return InnerInstanceGameVariableClazz.uniqueGameVariable ;
    }

}
