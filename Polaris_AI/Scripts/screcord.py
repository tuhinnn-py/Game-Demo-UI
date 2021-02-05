import numpy as np
import pyautogui
import cv2

RESOLUTION = (1280, 800)
CODEC = cv2.VideoWriter_fourcc(*"MJPG") 
FPS = 15.0
FILENAME = 'D:\\Demonstration.avi'
LEN = 60

out = cv2.VideoWriter(FILENAME, CODEC, FPS, RESOLUTION)
counter, seconds = 0, 0

while(seconds < LEN):
    img = pyautogui.screenshot() 
    counter += 1
    
    if(counter%60 == 0):
        seconds += 1
        
    frame = np.array(img) 
    frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB) 
    out.write(frame)  
    
out.release() 