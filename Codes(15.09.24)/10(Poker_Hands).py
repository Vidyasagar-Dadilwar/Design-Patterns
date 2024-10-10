from collections import defaultdict

def get_card_value(value):
    card_map = {str(c): c for c in range(2, 10)}
    card_map.update({'T': 10, 'J': 11, 'Q': 12, 'K': 13, 'A': 14})
    return card_map[value]

def get_card_suit(suit):
    suit_map = {'C': 1, 'D': 2, 'H': 3, 'S': 4}
    return suit_map[suit]

def parse_hand(hand):
    return sorted([(get_card_value(x[0]), get_card_suit(x[1])) for x in hand])

def get_groups(hand):
    count = defaultdict(int)
    for card in hand:
        count[card[0]] += 1
    return count

def is_flush(hand):
    return all(card[1] == hand[0][1] for card in hand)

def is_straight(hand):
    values = [card[0] for card in hand]
    return all(values[i] == values[i - 1] + 1 for i in range(1, len(values)))

def evaluate_hand(hand):
    groups = get_groups(hand)
    values = sorted(groups, key=lambda x: (-groups[x], -x))
    category = 0
    rank = []

    if is_flush(hand) and is_straight(hand):
        category = 9
        rank = [values[0]]
    elif 4 in groups.values():
        category = 8
        four_card = max(k for k, v in groups.items() if v == 4)
        kicker = max(k for k, v in groups.items() if v == 1)
        rank = [four_card, kicker]
    elif 3 in groups.values() and 2 in groups.values():
        category = 7
        three_card = max(k for k, v in groups.items() if v == 3)
        pair_card = max(k for k, v in groups.items() if v == 2)
        rank = [three_card, pair_card]
    elif is_flush(hand):
        category = 6
        rank = sorted([card[0] for card in hand], reverse=True)
    elif is_straight(hand):
        category = 5
        rank = [values[0]]
    elif 3 in groups.values():
        category = 4
        three_card = max(k for k, v in groups.items() if v == 3)
        kickers = sorted([k for k, v in groups.items() if v != 3], reverse=True)
        rank = [three_card] + kickers
    elif list(groups.values()).count(2) == 2:
        category = 3
        pairs = sorted([k for k, v in groups.items() if v == 2], reverse=True)
        kicker = max(k for k, v in groups.items() if v == 1)
        rank = pairs + [kicker]
    elif 2 in groups.values():
        category = 2
        pair_card = max(k for k, v in groups.items() if v == 2)
        kickers = sorted([k for k, v in groups.items() if v != 2], reverse=True)
        rank = [pair_card] + kickers
    else:
        category = 1
        rank = sorted([card[0] for card in hand], reverse=True)

    return category, rank

def compare_hands(black, white):
    black_category, black_rank = evaluate_hand(black)
    white_category, white_rank = evaluate_hand(white)
    
    if black_category != white_category:
        return black_category - white_category
    else:
        return (black_rank > white_rank) - (black_rank < white_rank)

while True:
    current_line = input().split()
    black_hand = parse_hand(current_line[:5])
    white_hand = parse_hand(current_line[5:])
    result = compare_hands(black_hand, white_hand)
    
    if result == 0:
        print("Tie.")
    else:
        print("Black wins." if result > 0 else "White wins.")