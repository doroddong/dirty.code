package ac.kr.ajou.dirt2;

import java.util.Set;

/*
public class SingMacIdentificationBuilder implements identificationBulder {

    @Override
    public Set<String> buildCombinedIdentification(PcBangEvent pbe) {

        private void bulidForSingleMac (PcBangEvent pbe, Set < String > combin){
            if (isValidForSingleMac(pbe.getMac())) {
                String[] macAddresses = pbe.getMac().split(",");
                if (macAddresses.length <= 100) {
                    for (int i = 0; i < macAddresses.length; i++) {
                        combin.add(macAddresses[i]);
                    }
                } else {
                    logErrorMessage("Mac address too many");
                }
            } else {
                logErrorMessage("Mac address is wrong");
            }
        }
        private boolean isValidForSingleMac (String mac){
            return mac != null && !mac.isEmpty();
        }
        private void logErrorMessage (String s){
            System.out.println(s);
        }
    }
}
*/