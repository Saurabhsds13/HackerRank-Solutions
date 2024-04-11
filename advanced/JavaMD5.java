package advanced;

import java.math.BigInteger;
import java.security.*;

/*MD5 is a cryptographic algorithm that provides the hash functions to get a fixed length 128-bit (16 bytes) hash value. Using Java, we can implement the MD5 hash in an application by using the MessageDigest class which is defined in java.security package. The Java MessageDigest class provides the following types of hash algorithms:

MD5
SHA-1
SHA-256

MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function with a -bit hash value. Here are some common uses for MD5:

To store a one-way hash of a password.
To provide some assurance that a transferred file has arrived intact.
MD5 is one in a series of message digest algorithms designed by Professor Ronald Rivest of MIT (Rivest,1994 ); however, the security of MD5 has been severely compromised, most infamously by the Flame malware in 2012. The CMU Software Engineering Institute essentially considers MD5 to be "cryptographically broken and unsuitable for further use".
*
*/
class MD5 {

  //hash function to get the md5 hash
  public String getMD5Hash(String input) throws NoSuchAlgorithmException {
    try {
      //static getInstance() method is called with hashing MD5
      MessageDigest md = MessageDigest.getInstance("MD5");
      //calculating message digest of an input that return array of byte
      byte[] messageDigest = md.digest(input.getBytes());
      //converting byte array into signum representation
      BigInteger no = new BigInteger(1, messageDigest);
      //converting message digest into hex value
      String hashtext = no.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) { //for specifying wrong message digest algorithms
      throw new RuntimeException(e);
    }
  }
}

public class JavaMD5 {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    MD5 md5 = new MD5();
    String s = "javatpoint";
    System.out.println("HashCode Generated for the string is: " + md5.getMD5Hash(s));
  }
}
