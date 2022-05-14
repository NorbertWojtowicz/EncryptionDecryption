# EncryptionDecryption

Simple project to encrypt and decrypt messages using shift or unicode algorithm.

Made in pure java to practice the **strategy design pattern**.

## Usage
Project requires few arguments to run properly:
- -mode - determine the program’s mode (enc for encryption, dec for decryption, default is enc mode)
- -key - integer key to modify the message (default key is 0)
- -alg - specify the algorithm (default is shift)
- -data - text or ciphertext to encrypt or decrypt (default data is an empty string)
- -in - full name of a file to read data from
- -out - full name of a file to write the result (by default, the program prints data to the standard output)

If there is no -data, and there is no -in the program assume that the data is an empty string.

If there are both -data and -in arguments, program prefer -data over -in.

If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value), program prints an error message.

### Example:
`java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode` - Program get data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

## Shift alghoritm:
It shifts each letter by the specified number according to its order in the alphabet in circle.

## Unicode algorithm
Similar to shift algoritm but based on unicode table.
