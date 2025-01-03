package com.example.project;

public class HorseBarn {
    /** The stalls in the barn. Each array element holds a reference to the Horse
     *  that is currently occupying the stall. A null value indicates an empty stall.
     */
    private Horse[] stalls;
 
 
    /** Initializes stalls to an array with a length equal to numStalls
     *  (all elements remain null initially)
     *
     *  @param numStalls  the number of stalls in the barn
     */
    public HorseBarn(int numStalls) {
        stalls = new Horse[numStalls];
    }
 
    /** Assigns stalls to reference sampleHorses
     */
    public HorseBarn(Horse[] sampleStalls) {
        stalls = sampleStalls;
    }
 
 
    /** Getter/accessor method for stalls
     *
     *  @return  a references to the stalls array
     */
    public Horse[] getStalls() {
        return stalls;
    }
 
 
    /** Returns a string that shows which horses are in which stalls
     */
    public String horseBarnInfo() {
        String result = "";
        Horse h = null;
        for (int i = 0; i < stalls.length; i++) {
            h = stalls[i];
            result = result + "Stall " + i + ": ";
            if (h == null) {
                result = result + "empty\n";
            } else {
                result = result + h.horseInfo() + "\n";
            }
        }
        return result;
    }
 
 
    /** Places a Horse into stalls at the index indicated by stall
     *
     *  PRECONDITION: stall is a valid index of stalls
     *
     *  @param horse  the Horse object to place into stalls
     *  @param stall  the index of stalls to place the Horse
     */
    public void placeHorse(Horse horse, int stall) {
        stalls[stall] = horse;
    }
 
 
    /** Returns the index of the stall that contains the horse with the specified name.
     *
     * Precondition: No two horses in the barn have the same name.
     *
     * @param  name the name of the horse to find
     * @return  the index of the stall containing the horse with the specified name;
     *          -1 if no horse with the specified name is in the barn.
     */
    public int findHorseStall(String name) {
        for (int i = 0; i < stalls.length; i++) {
            // takes advantage of short circuit evaluation of &&
            // to prevent null pointer exceptions
            if (stalls[i] != null && name.equals(stalls[i].getName())) {
                return i;
            }
        }
        return -1;
 
 
    }
 
 
    /** Consolidates the barn by moving horses so that the horses are in adjacent
     *  stalls, starting at index 0, with no empty stall between any two horses.
     *
     *  POSTCONDITION: The order of the horses is the same as before the consolidation.
     */
    public void consolidate() {
        // create temp array
        Horse[] newStalls = new Horse[stalls.length];
 
 
        // variable to track the next index in newStalls array to place a horse
        int nextSpot = 0;
 
 
        for (Horse nextHorse : stalls) {
            if (nextHorse != null) {
                newStalls[nextSpot] = nextHorse;
                nextSpot++;
            }
        }
 
 
        // assign stalls to the new array object
        stalls = newStalls;
    }

    public static void main (String[] args) {
        System.out.println("*** TESTING PART A: constructors and getter ***");
        HorseBarn barn1 = new HorseBarn(5);
        Horse[] horses1 = barn1.getStalls();
        for (Horse h : horses1) {
            System.out.println(h);
        }
        Horse h1 = new Horse("Abe", 1100);
        Horse h2 = new Horse("Barb", 1200);
        Horse h3 = new Horse("Cathy", 1300);
        Horse[] horses = {h1, h2, null, h3};
        HorseBarn barn2 = new HorseBarn(horses);
        Horse[] horses2 = barn2.getStalls();
        for (Horse h : horses2) {
            if (h != null) {
                System.out.println(h.horseInfo());
            } else {
                System.out.println(h);
            }
        }
 
 
        System.out.println("\n*** TESTING PART B: horseBarnInfo ***");
        System.out.println(barn1.horseBarnInfo());
        System.out.println(barn2.horseBarnInfo());
 
 
        System.out.println("\n*** TESTING PART C: placeHorse ***");
        HorseBarn sweetHome = new HorseBarn(7);
        sweetHome.placeHorse(new Horse("Trigger", 1340), 0);
        sweetHome.placeHorse(new Horse("Silver",1210), 2);
        sweetHome.placeHorse(new Horse("Lady", 1575), 3);
        sweetHome.placeHorse(new Horse("Patches", 1350), 5);
        sweetHome.placeHorse(new Horse("Duke", 1410), 6);
        System.out.println(sweetHome.horseBarnInfo());
 
 
        System.out.println("\n*** TESTING PART D: findHorseSpace ***");
        test("Trigger", 0, sweetHome);
        test("Silver", 2, sweetHome);
        test("Lady", 3, sweetHome);
        test("Patches", 5, sweetHome);
        test("Duke", 6, sweetHome);
        test("Coco", -1, sweetHome);
 
 
        System.out.println("\n*** TESTING PART E: consolidate ***");
        HorseBarn barn = new HorseBarn(7);
        barn.placeHorse(new Horse("Trigger", 1340), 0);
        barn.placeHorse(new Horse("Silver",1210), 2);
        barn.placeHorse(new Horse("Patches", 1350), 5);
        barn.placeHorse(new Horse("Duke", 1410), 6);
 
 
        System.out.println("Barn before consolidating:");
        System.out.println(barn.horseBarnInfo());
        barn.consolidate();
        System.out.println("Barn after consolidating:");
        System.out.println(barn.horseBarnInfo());
 
 
        test("Trigger", 0, barn);
        test("Silver", 1, barn);
        test("Patches", 2, barn);
        test("Duke", 3, barn);
        test("Coco", -1, barn);
    }
 
 
    public static void test(String name, int correctIdx, HorseBarn barn) {
        System.out.print("Index of " + name + " should be " + correctIdx + " and is " + barn.findHorseStall(name));
        if (barn.findHorseStall(name) == correctIdx) {
            System.out.println(" -- PASS");
        } else {
            System.out.println(" -- FAIL!!!!!");
        }
    }
 
 }
 