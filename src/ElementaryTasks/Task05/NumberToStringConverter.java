package ElementaryTasks.Task05;

import java.util.HashMap;

public class NumberToStringConverter {
    final static HashMap<Integer, String> DIGITMAP = new HashMap<>();
    final static HashMap<Integer, String> NUMBERMAP = new HashMap<>();
    private StringBuilder sourceString;

    public NumberToStringConverter(StringBuilder sourceString) {
        this.sourceString = sourceString;
    }

    public String convertNumberToString() {
        StringBuilder resNumber = new StringBuilder();
        if (sourceString.length() > 300) {
            return "I can't output number bigger then 10 in 300";
        }
        for (int j = 0; j < sourceString.length() / 3; j++) {
            int numberTo10 = Integer.parseInt(sourceString.substring(sourceString.length() - 3 * j - 1, sourceString.length() - 3 * j));
            int numberTo100 = Integer.parseInt(sourceString.substring(sourceString.length() - 3 * j - 2, sourceString.length() - 3 * j));
            int allDigits = Integer.parseInt(sourceString.substring(sourceString.length() - 3 * j - 3, sourceString.length() - 3 * j));
            String bigNumber = DIGITMAP.get(j);
            if (!bigNumber.isEmpty()) {
                if (j == 1) { //thousand
                    if (numberTo100 < 5 || numberTo100 > 20) {
                        if (numberTo10 == 1) {
                            bigNumber = String.format("%sa", bigNumber);
                        } else if (numberTo10 < 5) {
                            bigNumber = String.format("%sи", bigNumber);
                        }
                        if (numberTo10 == 1 || numberTo10 == 2) {
                            numberTo10 = -numberTo10;
                        }
                    }
                    if (numberTo100 == 1 || numberTo100 == 2) {
                        numberTo100 = -numberTo100;
                    }
                } else { // million and bigger
                    if ((numberTo100 >= 5) && (numberTo100 <= 20)) {
                        bigNumber = String.format("%sов", bigNumber);
                    } else {
                        if (numberTo10 > 1 && numberTo10 < 5) {
                            bigNumber = String.format("%sa", bigNumber);
                        } else if (numberTo10 != 1) {
                            bigNumber = String.format("%sов", bigNumber);
                        }
                    }
                }
            }
            if (allDigits > 0) {
                if (numberTo100 >= -2 && numberTo100 < 21) {
                    resNumber.insert(0, String.format("%s %s %s ",
                            NUMBERMAP.get(Integer.parseInt(String.format("%c00", sourceString.charAt(sourceString.length() - 3 * j - 3)))),
                            NUMBERMAP.get(numberTo100),
                            bigNumber));
                } else {
                    resNumber.insert(0, String.format("%s %s %s %s ",
                            NUMBERMAP.get(Integer.parseInt(String.format("%c00", sourceString.charAt(sourceString.length() - 3 * j - 3)))),
                            NUMBERMAP.get(Integer.parseInt(String.format("%c0", sourceString.charAt(sourceString.length() - 3 * j - 2)))),
                            NUMBERMAP.get(numberTo10),
                            bigNumber));
                }
            }
        }
        if (resNumber.toString().trim().length() == 0) {
            return "ноль";
        } else {
            return resNumber.toString().trim();
        }
    }

    static {
        NUMBERMAP.put(-1, "одна");
        NUMBERMAP.put(-2, "две");
        NUMBERMAP.put(0, "");
        NUMBERMAP.put(1, "один");
        NUMBERMAP.put(2, "два");
        NUMBERMAP.put(3, "три");
        NUMBERMAP.put(4, "четыре");
        NUMBERMAP.put(5, "пять");
        NUMBERMAP.put(6, "шесть");
        NUMBERMAP.put(7, "семь");
        NUMBERMAP.put(8, "восемь");
        NUMBERMAP.put(9, "девять");
        NUMBERMAP.put(10, "десять");
        NUMBERMAP.put(11, "одиннадцать");
        NUMBERMAP.put(12, "двенадцать");
        NUMBERMAP.put(13, "тринадцать");
        NUMBERMAP.put(14, "четырнадцать");
        NUMBERMAP.put(15, "пятнадцать");
        NUMBERMAP.put(16, "шестнадцать");
        NUMBERMAP.put(17, "семнадцать");
        NUMBERMAP.put(18, "восемнадцать");
        NUMBERMAP.put(19, "девятнадцать");
        NUMBERMAP.put(20, "двадцать");
        NUMBERMAP.put(30, "тридцать");
        NUMBERMAP.put(40, "сорок");
        NUMBERMAP.put(50, "пятьдесят");
        NUMBERMAP.put(60, "шестьдесят");
        NUMBERMAP.put(70, "семдесят");
        NUMBERMAP.put(80, "восемдесят");
        NUMBERMAP.put(90, "девяносто");
        NUMBERMAP.put(100, "сто");
        NUMBERMAP.put(200, "двести");
        NUMBERMAP.put(300, "триста");
        NUMBERMAP.put(400, "четыреста");
        NUMBERMAP.put(500, "пятьсот");
        NUMBERMAP.put(600, "шестьсот");
        NUMBERMAP.put(700, "семьсот");
        NUMBERMAP.put(800, "восемьсот");
        NUMBERMAP.put(900, "девятьсот");


        String[] arr1 = new String[9];
        String[] arr2 = new String[10];

        DIGITMAP.put(0, "");
        DIGITMAP.put(1, "тысяч");
        DIGITMAP.put(2, "миллион");
        DIGITMAP.put(3, "миллиард");
        DIGITMAP.put(4, "триллион");
        DIGITMAP.put(5, "квадриллион");
        DIGITMAP.put(6, "квинтиллион");
        DIGITMAP.put(7, "секстиллион");
        DIGITMAP.put(8, "септиллион");
        DIGITMAP.put(9, "октиллион");
        DIGITMAP.put(10, "нониллион");


        arr1[0] = "ан";
        arr1[1] = "дуо";
        arr1[2] = "тре";
        arr1[3] = "кваттор";
        arr1[4] = "квин";
        arr1[5] = "секс";
        arr1[6] = "септем";
        arr1[7] = "окто";
        arr1[8] = "новем";

        arr2[0] = "дециллион";
        arr2[1] = "вигинтиллион";
        arr2[2] = "квадрагинтиллион";
        arr2[3] = "квинквагинтиллион";
        arr2[4] = "сексагинтиллион";
        arr2[5] = "септуагинтиллион";
        arr2[6] = "октогинтиллион";
        arr2[7] = "нонагинтиллион";
        arr2[8] = "квинквагинтиллион";
        arr2[9] = "центиллион";

        for (int i = 0; i < arr2.length; i++) {
            DIGITMAP.put(11 + i * 10, arr2[i]);
            for (int j = 0; j < arr1.length; j++) {
                DIGITMAP.put(11 + i * 10 + j + 1, String.format("%s%s", arr1[j], arr2[i]));
            }
        }


    }

}
