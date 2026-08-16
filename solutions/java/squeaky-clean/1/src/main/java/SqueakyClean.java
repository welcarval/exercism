class SqueakyClean {

    static String clean(String identifier) {

        String s1 = whiteSpacetoUnderline(identifier);
        String s2 = formatKebab(s1);
        String s3 = letterToNormal(s2);
        String s4 = removerSymbols(s3);

        return s4;
    }

    static String whiteSpacetoUnderline(String identifier) {
        StringBuilder builder = new StringBuilder();

        for(char ch: identifier.toCharArray()) {
            builder.append(Character.isWhitespace(ch) ? "_" : ch);
        }

        return builder.toString();
    }

    static String formatKebab(String identifier) {
        StringBuilder builder = new StringBuilder();
        char[] arrayChar = identifier.toCharArray();

        for(int i = 0; i < arrayChar.length; i++) {
            if(arrayChar[i] == '-') {
                builder.append(Character.toUpperCase(arrayChar[i + 1]));
                i++;
            } else {
                builder.append(arrayChar[i]);
            }
        }

        return builder.toString();
    }

    static String letterToNormal(String identifier) {
        StringBuilder builder = new StringBuilder();

        char[] arrayChar = identifier.toCharArray();

        for (char ch : arrayChar) {
            switch (ch) {
                case '4':
                    builder.append('a');
                    break;
                case '3':
                    builder.append('e');
                    break;
                case '0':
                    builder.append('o');
                    break;
                case '1':
                    builder.append('l');
                    break;
                case '7':
                    builder.append('t');
                    break;
                default:
                    builder.append(ch);
                    break;
            }
        }

        return builder.toString();
    }

    static String removerSymbols(String identifier) {
        StringBuilder builder = new StringBuilder();
        char[] arrayChar = identifier.toCharArray();

        for(char ch : arrayChar) {
            if(Character.isLetter(ch) || ch == '_'){
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
