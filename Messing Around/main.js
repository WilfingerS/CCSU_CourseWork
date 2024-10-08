const monkeyFacts = [
    "Monkeys love bananas", "Monkeys are cool",
    "Monkeys went to space before humans did", "Monkey is spelled M-O-N-K-E-Y",
    "There is a very curious monkey, too bad i forgot his name", "Sun Wukong is the Monkey king",
    "Apes are not Monkeys", "Monkeys have high iq",
    "Monkeys live in trees", "A group of monkeys is called a troop",
    "Some monkeys have tails", "The Giant Monkey boss in Sekiro has a 2nd phase",
    "Monkey's mortal enemies are bloons", "A 4-0-1 alchemist monkey is more optimal than a 4-0-2",
    "Monkeys go ooo-ooo-aaa-aaa", "The pokemon Mankey is a reference to the word Monkey",
    "Super Monkey Ball is fun to play", "Barrel of Monkeys is entertaining to play with",
    "Gorillas are not monkeys but are classified as apes", "\"Filty Monkey\" refers to what Geto calls Non-Jujutsu Sorcerers in Jujutsu Kaisen",
    "Monkey D. Luffy is not a monkey but the user of the Hito-Hito no mi Model:Sun God Nika",
    "Sometimes monkeys sit on paths", "\"Nothing gets past my bow\" -Quincy after missing a shot",
    "Bananas are a great economic source for monkeys", "King Kong is not a monkey" , "Space Chimps is a good monkey movie",
    "Rise of the Planet of the Apes does not contain monkeys", "Planet of the Apes is not about monkeys", "In Season 4 of Spongebob there is a monkey",
    "C.H.I.M.P.S in BTD6 stands for no continues/hearts lost/income/monkey knowledge/powers/selling", "The JoJo Orangutan is a Stand user meaning there is no monkey stand users (yet)",
    "You can own an monkey as a pet", "Monkey (noun) means a small to medium-sized primate that typically has a long tail, most kinds of which live in trees in tropical countries.",
    "Monkey (verb) means: behave in a silly or playful way.", "The Flying Dutchman can tie the monkey chain knot", "The Flying Dutchman can tie the monkey's fist knot", "The Flying Dutchman can tie the monkey knot",
    "Monkeys love powerade!", "7 little monkeys jumped on a bed all fell off and bumped their head, no more jumping on the bed", "Oogway chose Monkey for furious five",
    "In the 1980's Sony did a commercial for their Sony Walkman with a monkey", "In Toy Story 3 there was a security monkey", 
    "Nim's (monkey) longest sentence recorded was:\ngive orange me give eat orange me eat orange give me eat orange give me you",

]

let knownFact = Array();


function random(min,max){
    return Math.floor(Math.random() * (max-min) + min);
}

function updateText(element,text){
    element.innerText = text;
}
function onClick(mouseEvent) {
    let randNum = random(0,monkeyFacts.length);
    let randomFact = monkeyFacts[randNum];
    let extralearnedText = "";
    if (!knownFact.includes(randNum)){
        knownFact[knownFact.length] = randNum;
    }
    if (knownFact.length >= monkeyFacts.length) {
        extralearnedText = "Congrats you learned them all!!!\n"
    }
    updateText(document.getElementById("learnedFacts"),`${extralearnedText}Learned Facts: ${knownFact.length}/${monkeyFacts.length}`);
    updateText(document.getElementById("response"),randomFact);
}

function init(){
    updateText(document.getElementById("learnedFacts"),`Learned Facts: ${knownFact.length}/${monkeyFacts.length}`);
}