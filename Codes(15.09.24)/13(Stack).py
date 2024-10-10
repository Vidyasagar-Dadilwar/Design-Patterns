from collections import defaultdict

DECK_SIZE = 52

# Initialize the card mapping
def initialize():
    card_map = {}
    k = 0
    suits = ["Clubs", "Diamonds", "Hearts", "Spades"]
    for suit in suits:
        for i in range(2, 11):
            card_map[k] = f"{i} of {suit}"
            k += 1
        card_map[k] = f"Jack of {suit}"
        k += 1
        card_map[k] = f"Queen of {suit}"
        k += 1
        card_map[k] = f"King of {suit}"
        k += 1
        card_map[k] = f"Ace of {suit}"
        k += 1
    return card_map

# Create a new deck of cards
def new_deck():
    return list(range(DECK_SIZE))

# Apply a shuffle to the deck
def apply(deck, shuffle):
    output = new_deck()
    for j in range(len(shuffle)):
        output[j] = deck[shuffle[j]]
    return output

# Perform shuffles based on the provided shuffle indexes and list of shuffles
def shuffle(shuffle_indexes, shuffles):
    deck = new_deck()
    for i in shuffle_indexes:
        deck = apply(deck, shuffles[i])
    return deck

def main():
    import sys
    input = sys.stdin.read
    data = input().strip().splitlines()

    card_map = initialize()
    index = 0
    cases = int(data[index].strip())
    index += 1
    index += 1  # Skip the empty line

    results = []

    for _ in range(cases):
        n = int(data[index].strip())
        index += 1
        shuffles = []
        while len(shuffles) < n * DECK_SIZE:
            current_line = data[index].strip()
            if current_line:
                shuffles.extend(map(int, current_line.split()))
            index += 1

        # Adjust to zero-based index
        shuffles = [x - 1 for x in shuffles]

        shuffle_list = [shuffles[i * DECK_SIZE:(i + 1) * DECK_SIZE] for i in range(n)]
        shuffle_indexes = []

        while index < len(data) and data[index].strip():
            shuffle_indexes.append(int(data[index].strip()) - 1)
            index += 1
        
        # Perform the shuffling
        final_deck = shuffle(shuffle_indexes, shuffle_list)
        
        for card in final_deck:
            results.append(card_map[card])
        
        results.append("")  # To add a blank line after each case

    # Print the results
    print("\n".join(results).strip())

if __name__ == "__main__":
    main()
