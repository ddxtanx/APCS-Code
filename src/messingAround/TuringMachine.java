package messingAround;

public class TuringMachine {
    public static void main(String[] args) {
        String initialTape = "00100";
        String[] rules = {"1 R 0 1 L 2", "1 L 1 0 R 0", "1 L 1 1 R 3"};
        int initialHeadIndex = 0;
        TuringMachine t = new TuringMachine(initialTape, rules, initialHeadIndex);
        t.run();
    }
    String tape;
    //Infinite tape is 'pre-filled' with 0's
    String[] rules;
    //Rules will be in the format [WRITE if 0] [MOVE if 0] [NEXT STATE if 0] [WRITE if 1] [MOVE if 1] [NEXT STATE if 1]
    int headIndex;
    int currentState;
    public TuringMachine(String initialTape, String[] rules, int initialHeadIndex){
        this.tape = initialTape;
        this.rules = rules;
        if(rules.length == 0){
            throw new IllegalArgumentException("Rules array must not be empty");
        }
        currentState = 0;
        if(initialHeadIndex >= 0 && initialHeadIndex < initialTape.length()){
            headIndex = initialHeadIndex;
        } else{
            throw new IllegalArgumentException("Initial Tape must be big enough to contain initial head index.");
        }
    }

    public void run(){
        String num;

        if(headIndex>=0 && headIndex<tape.length()){
            num = tape.substring(headIndex, headIndex+1);
        } else{
            num = "0";
            if(headIndex<0){
                tape = "0" + tape;
                headIndex++;
            } else{
                tape = tape + "0";
            }
        }
        System.out.println("Start:----");
        System.out.println(tape);
        System.out.println("Header at " + headIndex + ", value read " + num + ", current state " + currentState);
        System.out.println("-----:End");
        String[] ruleSplit = rules[currentState].split(" "); //Splits 1 1 1 0 0 0 into array
        if(num.equals("0")){
            StringBuilder newTape = new StringBuilder(tape);
            newTape.setCharAt(headIndex, ruleSplit[0].toCharArray()[0]);
            tape = newTape.toString();

            headIndex = (ruleSplit[1].equals("L"))?(headIndex-1):(headIndex+1);

            currentState = Integer.parseInt(ruleSplit[2]);
        } else{
            StringBuilder newTape = new StringBuilder(tape);
            newTape.setCharAt(headIndex, ruleSplit[3].toCharArray()[0]);
            tape = newTape.toString();

            headIndex = (ruleSplit[4].equals("L"))?(headIndex-1):(headIndex+1);

            currentState = Integer.parseInt(ruleSplit[5]);
        }

        if(currentState<rules.length){
            run();
        } else{
            System.out.println("FINISHED-----");
            System.out.println(tape);
            System.out.println("Header at " + headIndex + ", value read " + num + " current state " + currentState);
            System.out.println("-----:End");
        }
    }
}
