package com.includehelp

import java.lang.IllegalArgumentException
import java.util.*

fun main()
{
    var rows1:Int
    var col1:Int
    var rows2:Int
    var col2:Int
    var skalar:Int
    val matriks = FunMatrix()
    val reader = Scanner(System.`in`)
    var choice:Int
    do {
        println("SELECT THE PROGRAM")
        println("1. Addition Matrix")
        println("2. Multiplication Matrix")
        println("3. Tranpose")
        println("4. Subtraction")
        println("5. Multiplication Matrix & Skalar")
        println("6. Determinant Matrix")
        println("7. Rank of Matrix")
        println("Input Your Choice : ")
        choice = reader.nextInt()
        if (choice == 1) {
            matriks.Addition()
        }
        else if(choice == 2){
            println("Enter the number of rows matrix 1 (1 - 10)\t\t: ")
            rows1 = reader.nextInt()
            println("Enter the number of coloums matrix 1 (1 - 10)\t: ")
            col1 = reader.nextInt()
            println("Enter the number of rows matrix 2 (1 - 10)\t\t: ")
            rows2 = reader.nextInt()
            println("Enter the number of coloums matrix 2 (1 - 10)\t: ")
            col2 = reader.nextInt()
            if(col1 == rows2){
                matriks.Multiplication(rows1,rows2,col1,col2)
            }else{
                throw IllegalArgumentException("Matrices cannot be multiplied")
            }
        }
        else if(choice == 3){
            matriks.Tranpose()
        }
        else if(choice == 4){
            matriks.Subtraction()
        }
        else if(choice == 5){
            println("Enter the number of rows matrix (1 - 10)\t\t: ")
            rows1 = reader.nextInt()
            println("Enter the number of coloums matrix (1 - 10)\t: ")
            col1 = reader.nextInt()
            println("Input Skalar Value :")
            skalar = reader.nextInt()
            matriks.MultiplicationSkalar(rows1,col1,skalar)

        }else if(choice == 6){
            println("Enter the Dimension of Matrix\t: ")
            rows1 = reader.nextInt()
            var matrix = Array(rows1){IntArray(rows1)}
            println("Enter the Elements of Matrix ($rows1 X $rows1} ): ")
            for(i in matrix.indices){
                for(j in matrix[i].indices){
                    print("First Matrix[${i+1}][${j+1}]: ")
                    matrix[i][j]=reader.nextInt()
                }
            }
            matrix = Array(rows1){IntArray(rows1)}
            val determinant = matriks.Determinant(matrix)
            println("The determinant of the matrix is: ${determinant.toInt()}")
        }
        else if(choice == 7){
            println("")
        }
    }while (choice<=6)

}