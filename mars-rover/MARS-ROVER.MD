# Mars Rover Kata

## Requirements
[Mars Rover Kata Requirements](REQUIREMENTS.MD)

The solution wasn't hard to find. 
I decided to put 'position-transitioning' logic into a few related immutable domain classes. 

I don't really like mixed state (position) and dependencies (log and map) of MarsRover, but I do not think that 
in case of extraction of some service class operating on MarsRover I can put anything meaningful into the MarsRover class. 
So there is a tradeoff here, while command execution logic is cohesive to MarsRover data.

I failed to implement 'wrapping at edges' because I didn't understand the task clearly, so I skipped it. 
Lately, I decided to retain euclidian geometry for simplicity and implement Planet map.

_Time spent: 3 hours_
