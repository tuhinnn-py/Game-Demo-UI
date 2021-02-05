import numpy as np
import pyautogui
import cv2

RESOLUTION = (1280, 800)
CODEC = cv2.VideoWriter_fourcc(*"MJPG") 
FPS = 15.0
FILENAME = 'C:\\Users\\hp\\Desktop\\Polaris_AI\\src\\polaris_ai\\Demonstration.avi'
LEN = 44
INITIAL_TRIM = 8
FINAL_TRIM = 40

in_read = cv2.VideoCapture('D:\\Demonstration.avi')
out = cv2.VideoWriter(FILENAME, CODEC, FPS, RESOLUTION)
counter = 0

while(counter < LEN * FPS):
    ret, frame = in_read.read()
    counter += 1
    
    if(counter >= INITIAL_TRIM * FPS and counter <= FINAL_TRIM * FPS):
        out.write(frame)  
    
out.release() 