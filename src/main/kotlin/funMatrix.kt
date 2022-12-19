package com.includehelp
import java.util.*

class FunMatrix {
    private var rows:Int = 0
    private var col:Int = 0
    private val scan = Scanner(System.`in`)
    private fun InputSingleSizeMatrix(){
        println("Enter the number of rows matrix (1 - 10)\t: ")
        rows = scan.nextInt()
        println("Enter the number of coloums matrix (1 - 10)\t: ")
        col = scan.nextInt()
    }
    private fun Printmatrix(row:Array<IntArray>) {
        for(i in row.indices){
            println("${row[i].contentToString()} ")
        }
    }
    fun Addition(){
        InputSingleSizeMatrix()
        val a = Array(rows){IntArray(col)}
        val b = Array(rows){IntArray(col)}
        val c = Array(rows){IntArray(col)}
        println("Enter the Elements of First Matrix ($rows X $col} ): ")
        for(i in a.indices){
            for(j in a[i].indices){
                print("First Matrix[${i+1}][${j+1}]: ")
                a[i][j]=scan.nextInt()
            }
        }
        //Input Matrix
        println("Enter the Elements of Second Matrix ($rows X $col} ): ")
        for(i in b.indices){
            for(j in b[i].indices){
                print("Second Matrix [${i+1}][${j+1}]: ")
                b[i][j]=scan.nextInt()
            }
        }
        println("The First Matrix is : ")
        Printmatrix(a)
        println("The Second Matrix is : ")
        Printmatrix(b)
        for(i in c.indices){
            for(j in c[i].indices){
                c[i][j]=a[i][j]+b[i][j]
            }
        }
        println("Sum of the Matrices:")
        Printmatrix(c)
    }
    fun Multiplication(row1:Int,row2:Int,col1:Int,col2:Int){
        val scan = Scanner(System.`in`)

        val a = Array(row1){IntArray(col1)}
        val b = Array(row2){IntArray(col2)}
        val c = Array(row1){IntArray(col2)}

        println("Enter the Elements of First Matrix ($row1 X $col1} ): ")
        for(i in a.indices){
            for(j in a[i].indices){
                print("First Matrix[${i+1}][${j+1}]: ")
                a[i][j]=scan.nextInt()
            }
        }

        //Input Matrix
        println("Enter the Elements of Second Matrix ($row2 X $col2} ): ")
        for(i in b.indices){
            for(j in b[i].indices){
                print("Second Matrix [${i+1}][${j+1}]: ")
                b[i][j]=scan.nextInt()
            }
        }
        println("The First Matrix is : ")
        Printmatrix(a)
        println("The Second Matrix is : ")
        Printmatrix(b)
        for(i in c.indices){
            for(j in c[i].indices){
                for(k in b.indices) {
                    c[i][j] = c[i][j] + (a[i][k] * b[k][j])
                }
            }
        }

        println("Result of the Matrix Multiplication : ")
        Printmatrix(c)
    }
    fun Tranpose(){
        InputSingleSizeMatrix()
        val a = Array(rows){IntArray(col)}
        val c = Array(col){IntArray(rows)}

        println("Enter the Elements of Matrix ($rows X $col} ): ")
        for(i in a.indices){
            for(j in a[i].indices){
                print("First Matrix[${i+1}][${j+1}]: ")
                a[i][j]=scan.nextInt()
            }
        }

        println("The Matrix is : ")
        Printmatrix(a)
        for (i in a.indices){
            for(j in a[i].indices){
                c[j][i] = a[i][j]
            }
        }
        println("Result of the Matrix Tranpose : ")
        Printmatrix(c)
    }
    fun Subtraction(){
        InputSingleSizeMatrix()
        val a = Array(rows){IntArray(col)}
        val b = Array(rows){IntArray(col)}
        val c = Array(rows){IntArray(col)}
        println("Enter the Elements of First Matrix ($rows X $col} ): ")
        for(i in a.indices){
            for(j in a[i].indices){
                print("First Matrix[${i+1}][${j+1}]: ")
                a[i][j]=scan.nextInt()
            }
        }
        //Input Matrix
        println("Enter the Elements of Second Matrix ($rows X $col} ): ")
        for(i in b.indices){
            for(j in b[i].indices){
                print("Second Matrix [${i+1}][${j+1}]: ")
                b[i][j]=scan.nextInt()
            }
        }
        println("The First Matrix is : ")
        Printmatrix(a)
        println("The Second Matrix is : ")
        Printmatrix(b)
        for(i in c.indices){
            for(j in c[i].indices){
                c[i][j]=a[i][j]-b[i][j]
            }
        }
        println("Sub of the Matrices:")
        Printmatrix(c)
    }
    fun MultiplicationSkalar(row:Int,col:Int,skalar:Int){
        val scan = Scanner(System.`in`)

        val a = Array(row){IntArray(col)}
        val c = Array(row){IntArray(col)}

        println("Enter the Elements of Matrix ($row X $col} ): ")
        for(i in a.indices){
            for(j in a[i].indices){
                print("First Matrix[${i+1}][${j+1}]: ")
                a[i][j]=scan.nextInt()
            }
        }
        println("The Matrix is : ")
        Printmatrix(a)
        println("Value of Skalar : ${skalar} ")
        for(i in a.indices){
            for(j in a[i].indices){
                c[i][j] = a[i][j]*skalar
            }
        }

        println("Result of the Matrix Multiplication : ")
        Printmatrix(c)
    }
    fun Determinant(matrix: Array<IntArray>):Double {
        val result:Double
        if (matrix.size == 1){
            result = matrix[0][0].toDouble()
            return result
        }
        if(matrix.size == 2){
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]).toDouble()
        }else{
            var determinant = 0.0
            for(i in matrix.indices){
                val minor = Minor(matrix,i,0)
                determinant += Math.pow(-1.0,i.toDouble()) * matrix[i][0] * Determinant(minor)
            }
            return determinant
        }
    }

    fun Minor(matrix: Array<IntArray>, row: Int, column: Int): Array<IntArray> {
        return Array(matrix.size - 1) { i ->
            IntArray(matrix.size - 1) { j ->
                var newRow = i
                var newCol = j
                if (i >= row) newRow++
                if (j >= column) newCol++
                matrix[newRow][newCol]
            }
        }
    }
}

