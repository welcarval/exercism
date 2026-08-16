public class FootballMatchReports {    
    public static String onField(int shirtNum) {
        String text;
        switch (shirtNum) {
            case 1:
                text = "goalie";
                break;
            case 2:
                text = "left back";
                break;
            case 3:
            case 4:
                text = "center back";
                break;
            case 5:
                text = "right back";
                break;
            case 6:
            case 7:
            case 8:
                text = "midfielder";
                break;
            case 9:
                text = "left wing";
                break;
            case 10:
                text = "striker";
                break;
            case 11:
                text = "right wing";
                break;
            default:
                text = "invalid";
                break;
        }
        return text;
    }
}
