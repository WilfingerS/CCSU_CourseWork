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
]


function random(min,max){
    return Math.floor(Math.random() * (max-min) + min);
}

function onClick(mouseEvent) {
    let randNum = random(0,monkeyFacts.length);
    let randomFact = monkeyFacts[randNum];
    document.getElementById("response").innerText = randomFact;
}