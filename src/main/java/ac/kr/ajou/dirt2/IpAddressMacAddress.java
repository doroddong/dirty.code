package ac.kr.ajou.dirt2;

import java.util.HashSet;
import java.util.Set;

public class IpAddressMacAddress {

    // single ip, single mac, accountId, ip + mac
    public Set<String> buildCombinedIdentification(PcBangEvent pbe) {
        Set<String> combinedIdentification = new HashSet<String>();
        // single IP
        bildForsingleIP(pbe, combinedIdentification);
        // single mac
        bulidForSingleMac(pbe, combinedIdentification);
        // accountId
        buildForAccountId(pbe, combinedIdentification);
        // ip + mac
        buildForIpAndMac(pbe, combinedIdentification);

        return combinedIdentification;
    }
    private void buildForIpAndMac(PcBangEvent pbe, Set<String> combin) {
        if (isValidForSingleMac(pbe.getMac())) {
            if (isValidForSingleMac(pbe.getIp())) {
                String[] macAddresses = pbe.getMac().split(",");
                if (macAddresses.length <= 100) {
                    for (int i = 0; i < macAddresses.length; i++) {
                        combin.add(pbe.getIp() + macAddresses[i]);
                    }
                }
            }
        }
    }

    private boolean isValidForSingleMac(String mac) {
        return mac != null && !mac.isEmpty();
    }

    private void buildForAccountId(PcBangEvent pbe, Set<String> combin) {
        if (isValidAccountId(pbe)) {
            if (!pbe.getAccountId().equals("0")) {
                combin.add(pbe.getAccountId());
            } else {
                logErrorMessage("Account id can't be 0");
            }
        } else {
            logErrorMessage("Account is is null or empty");
        }
    }

    private boolean isValidAccountId(PcBangEvent pbe) {
        return isValidForSingleMac(pbe.getAccountId());
    }

    private void logErrorMessage(String s) {
        System.out.println(s);
    }

    private void bulidForSingleMac(PcBangEvent pbe, Set<String> combin) {
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

    private void bildForsingleIP(PcBangEvent pbe, Set<String> combin) {
        if (pbe.getIp() != null) {
            combin.add(pbe.getIp());
        }
    }
}
