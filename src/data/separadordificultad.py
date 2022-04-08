facil = open("Frances_Facil.txt","w")
medio = open("Frances_Medio.txt","w")
dificil = open("Frances_Dificil.txt","w")
with open("listaFrances.txt","r") as archivo:
    for palabra in archivo:
        if len(palabra) == 6:
            facil.write(palabra)
        if len(palabra) > 6 and len(palabra) < 9:
            medio.write(palabra)
        if len(palabra) >= 9:
            dificil.write(palabra)
    archivo.close()
facil.close()
medio.close()
dificil.close()







