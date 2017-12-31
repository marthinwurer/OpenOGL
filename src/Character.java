import java.util.Random;

/**
 * Created by benjamin on 10/3/16.
 */
public class Character {
    private int hp;
    private int ac;
    private int x;
    private int y;
    private int toHit;
    private int initiative = 0;
    private int speed;

    private int strength = 10;
    private int dexterity = 10;
    private int constitution = 10;
    private int intelligence = 10;
    private int wisdom = 10;
    private int charisma = 10;

    private String name;

    /*
        At the start of a battle, before you have had a chance to act
        (specifically, before your first regular turn in the initiative order),
        you are flat-footed.
     */
    private boolean flatfooted = true;

    public static int getMod(int stat){
        return stat / 2 - 5;
    }

    Character(String name, int hp, int ac, int x, int y, int toHit, int dexterity ){
        this.name = name;
        this.hp =  hp;
        this.ac = ac;
        this.x = x;
        this.y = y;
        this.toHit = toHit;
        this.speed = 30;
        this.dexterity = dexterity;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getToHit() {
        return toHit;
    }

    public void setToHit(int toHit) {
        this.toHit = toHit;
    }

    public int getInitMod() {
        return getDexMod();
    }


    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void genInitiative(Dice die){
        /*
        An initiative check is a Dexterity check. Each character applies his or her Dexterity modifier to the roll.
         */
        this.initiative = die.d20() + getInitMod();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    /**
     *
     * @param other
     * @return the difference in inititive scores. Positive if the other character will act after this one.
     */
    public int initiativeCompare(Character other){
        /*
            Characters act in order, counting down from highest result to lowest
         */
        if( this.getInitiative() != other.getInitiative()){
            return this.getInitiative() - other.getInitiative();
        }else{
            /*
                If two or more combatants have the same initiative check result,
                the combatants who are tied act in order of total initiative modifier
                (highest first). If there is still a tie, the tied characters should
                roll again to determine which one of them goes before the other.
             */
            int diff = this.getInitMod() - other.getInitMod();
            return diff;
//            if ( diff == 0){
//                return new Random().nextInt();
//            }else{
//                return diff;
//            }
        }

    }

    public int getStrength() {
        return strength;
    }

    public int getStrMod(){
        return getMod(strength);
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getDexMod(){
        return getMod(dexterity);
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getConMod(){
        return getMod(constitution);
    }


    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getIntMod(){
        return getMod(intelligence);
    }


    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getWisMod(){
        return getMod(wisdom);
    }


    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getChaMod(){
        return getMod(charisma);
    }


    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.getInitiative();
    }
}
