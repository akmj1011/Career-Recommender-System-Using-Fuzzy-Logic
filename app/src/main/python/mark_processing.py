import numpy as np
import skfuzzy as fuzz
from skfuzzy import control as ctrl
import matplotlib.pyplot as plt
import cv2
import io
from PIL import Image
import base64

def main(m,p,cs,c):
    '''m=int(input("Enter your marks in Mathematics : "))
    p=int(input("Enter your marks in Physics : "))
    cs=int(input("Enter your marks in Computer Science : "))
    c=int(input("Enter your marks in Chemistry : "))'''
    #print()
    master_d={}
    mark_list=[int(m),int(p),int(cs),int(c)]

    sum1=0
    sum2=0
    mark_count=0
    Scr_List=[]
    subjects=["Computer Science and Engineering","Electrical Engineering","Civil Engineering","Chemical Engineering","Mechanical Engineering"]
    weightage={"Computer Science":[2,1,2,1],"Electrical Engineering":[2,2,2,1],"Civil Engineering":[2,2,1,1],"Chemical Engineering":[2,1,1,2],"Mechanical Engineering":[2,2,1,1]}

    for i in weightage:
        for j in mark_list:
            sum1+=j*(weightage[i][mark_count])
            sum2+=weightage[i][mark_count]
            mark_count+=1
        Scr_List+=[sum1/sum2]
        sum1=0
        sum2=0
        mark_count=0
        
    Academic_Scr = ctrl.Antecedent(np.arange(0, 101, 1), 'Academic Score')
    Suitability = ctrl.Consequent(np.arange(0, 101, 1), 'Suitability')

    Academic_Scr['Fail'] = fuzz.trapmf(Academic_Scr.universe, [0, 0, 30, 41])
    Academic_Scr['Satisfactory'] = fuzz.trapmf(Academic_Scr.universe, [31, 50, 65, 70])
    Academic_Scr['Good'] = fuzz.trapmf(Academic_Scr.universe, [60, 70, 75, 80])
    Academic_Scr['Very Good'] = fuzz.trapmf(Academic_Scr.universe, [75, 85, 90, 95])
    Academic_Scr['Excellent'] = fuzz.trapmf(Academic_Scr.universe, [85, 95, 100, 100])


    #Academic_Scr.view()

    Suitability['Bad'] = fuzz.trapmf(Suitability.universe, [0, 0, 30, 40])
    Suitability['Average'] = fuzz.trapmf(Suitability.universe, [30, 40, 50, 60])
    Suitability['Good'] = fuzz.trapmf(Suitability.universe, [50, 65, 100, 100])

    #Suitability.view()

    rule1 = ctrl.Rule(Academic_Scr['Fail'], Suitability['Bad'])
    rule2 = ctrl.Rule(Academic_Scr['Satisfactory'], Suitability['Average'])
    rule3 = ctrl.Rule(Academic_Scr['Good'], Suitability['Average'])
    rule4 = ctrl.Rule(Academic_Scr['Very Good'], Suitability['Good'])
    rule5 = ctrl.Rule(Academic_Scr['Excellent'], Suitability['Good'])

    Suit_ctrl = ctrl.ControlSystem([rule1, rule2, rule3, rule4, rule5])
    Suit = ctrl.ControlSystemSimulation(Suit_ctrl)

    Suit_list=[]
    for i in range(len(Scr_List)):
        Suit.input['Academic Score'] = Scr_List[i]
        Suit.compute()
        #print("Suitability for ",subjects[i],": ",end='')
        #print(Suit.output['Suitability']," %")
        Suit_list+=[Suit.output['Suitability']]
        #master_d[subjects[i]]=Suit.output['Suitability']
        #print('\n')
        #Suitability.view(sim=Suit)
    max_suit=max(Suit_list)
    max_subject=subjects[Suit_list.index(max_suit)]
    return (max_subject,max_suit,subjects,Suit_list)
    #print(Suit_list)

#print(main('98','74','54','85'))
