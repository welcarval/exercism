class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if(fighter.isVulnerable()){
            return 10;
        } else {
            return 6;
        }
    }
}

class Wizard extends Fighter {

    private boolean preparedSpell = false;

    public void prepareSpell() {
        this.preparedSpell = true;
    }

    @Override
    boolean isVulnerable() {
        return !this.preparedSpell;
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if(preparedSpell) {
            return 12;
        } else {
            return 3;
        }
    }
    
}
