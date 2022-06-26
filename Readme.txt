(Inprogress...)

Scoring Bowling Game:

The game consists of 10 frames as shown above.  In each frame the player has
two opportunities to knock down 10 pins.  The score for the frame is the total
number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two tries.  The bonus for
that frame is the number of pins knocked down by the next roll.  So in frame 3
above, the score is 10 (the total number knocked down) plus a bonus of 5 (the
number of pins knocked down on the next roll.)

A strike is when the player knocks down all 10 pins on his first try.  The bonus
for that frame is the value of the next two balls rolled.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra
balls to complete the frame.  However no more than three balls can be rolled in
tenth frame.

Write a class named “Game” that has two methods
roll(pins : int) is called each time the player rolls a ball.  The argument is the number of pins knocked down.
score() : int is called only at the very end of the game.  It returns the total score for that game.

Requirements:
1. Game contains 10 frames
2. Each frame user gets 2 chance to knockdown all the pins (Except 10th frame in which extra
chance will get if last turn is spare)
3. Number of points equals to balls knockdown in particular frame
4. In case of spare, bonus equals to balls knockdown in next frame first attempt
5. In case of strike, bonus equals to balls knockdown in next frame 2 attempts
6. Total sum is sum of all frames
7. Each frame size is sum of balls knockdown + bonus if any


Test cases:
1. If in a pass 2 balls are knockdown then total sum will be 2
2. If in a next pass 8 balls are knockdown then total sum will be 10
3. If 10 balls are knockdown in single run in frame 1 then new frame should be 2
4. If 10 balls are knockdown  in 2 run in frame 2 then new frame should be 3
5. If in 2 attempts, 10 balls are not knockdown, then move to next frame and reset attempt counter
6. In a frame not more than 10 balls can be knockdown
7. If 8 ball is knockdown in 2 attempts in frame 3 then total sum is increased by 8
8. In case of spare in frame 3, and frame 4, fist attempt 5 balls are knockdown
 then sum should increase the sum by 15
9.In case of strike in frame 3, and frame 4, 10 balls are knockdown
  then sum should increase the sum by 20
10. In 10th frame, 2nd attempt strike is hit then 3rd attempt user knockdown 5 then total sum increase by 15
 for that frame

After test 2, I realised that I can't move forward without having Frame class defined. So writing a few
test cases for it before moving ahead.

1. If in a frame during first attempt 10 balls are knockdown then no more try should be done
2. In case number of balls are more than 10 in frame then throw exception
3. Should return frame sum to 10 when 10 balls knock down in 2 attempts
4. In case sum is called before any frame order then exception should be thrown
5. If strike is hit then sum of that frame is 10 + balls knock down in next frame first attempt
6. If spare is hit then sum of that frame is 10 + balls knock down in next frame 2 attempts
7. Sum of this frame is this frame sum plus previous frame sum, previous sum is 0 for first frame