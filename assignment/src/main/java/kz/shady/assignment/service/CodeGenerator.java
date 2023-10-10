package kz.shady.assignment.service;

import kz.shady.assignment.entity.Code;
import kz.shady.assignment.repository.CodeRepository;
import kz.shady.assignment.util.ObjectCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGenerator {
    @Autowired
    CodeRepository codeRepository;
    public String getNextCode() {
        Code code = codeRepository.findTopByOrderByIdDesc();
        String currentCode = "";
        if (ObjectCheck.isBlank(code) || ObjectCheck.isBlank(code.getCurrentCode())) {
            currentCode = "a0a0";
        } else {
            currentCode = generateCode(code.getCurrentCode());
        }
        code.setCurrentCode(currentCode);
        codeRepository.save(code);
        return currentCode;
    }
    public String generateCode(String currentCode) {
        char[] codeArr = currentCode.toCharArray();
        int lastIndex = codeArr.length - 1;
        if (isLimited(codeArr)) {
            return new String(limitChecker(codeArr));
        }
        while (lastIndex >= 0) {
            char lastChar = codeArr[lastIndex];
            if (lastChar == '9') {
                codeArr[lastIndex] = '0';
                lastIndex--;
            } else if (lastChar == 'z') {
                codeArr[lastIndex] = 'a';
                lastIndex--;
            } else {
                codeArr[lastIndex]++;
                break;
            }
        }
        return new String(codeArr);
    }

    private boolean isLimited(char[] codeArr) {
        int countZ = 0;
        int count9 = 0;
        for (char c : codeArr) {
            if (c == 'z') {
                countZ++;
            }
        }
        for (char c : codeArr) {
            if (c == '9') {
                count9++;
            }
        }
        if ((countZ == count9 && countZ == codeArr.length/2)) {
            return true;
        }
        return false;
    }


    private char[] limitChecker(char[] codeArr){
        int formulatedLength = codeArr.length + 2;
        char[] limitedArr  = new char[formulatedLength];
        for (int i = 0; i < (formulatedLength); i++) {
            limitedArr[i] = 'a';
            limitedArr[i + 1] = '0';
            i++;
        }
        return limitedArr;
    }
}
