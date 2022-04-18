package com.bolsadeideas.springboot.backend.apirest.auth;

public class JwtConfig {

    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
    public static final String RSA_PRIVADA = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDJr5JkpnVGIhVm\n" +
            "xrH1BCtQlnbPtQLJKwjQYH/xsnYiM6yS5YBehPJN2d2Iy530v8t2WrAukk9Mynkt\r\n" +
            "Iil9SxH5GxKJN5mW0u42K2z2SPaxnVH18tQNDPKSWZwfuGUomAaGuRSBUGt7ftae\r\n" +
            "k3Aek6uMiRBlRVKqH8G8STdnPgowH56+fekItfAp2OWgmPHcv8ECOdhmrJ2C7oGE\r\n" +
            "Fp0hMuSYUEYiBUgpq+nzOd6uOdlch1Egn0xJN7wQXkaL6R2QdWtX0ibVgtOAJ2Ek\r\n" +
            "hy9GniQcSVwRhO9wCquZZ/h2e5DiLqr2MvaqXGWnqUUcxnQSC2c4JkMHSHu0KcvP\r\n" +
            "bmFIa8m7AgMBAAECggEAMbD7XacRj+UH5tmfsOGFFobr4QMVG6Fpu4V7IH660nRu\r\n" +
            "2YaIGUGiPYInLfQVB99VbuSrMd5EgYQFVRRsqn0bgYelCn/TbLCtllUetJOHjH1Z\r\n" +
            "W0Kn8ks1XM+NQtd4vQav3POu1KmOwc+fa1SiNDZn9ukyS/FHi7jlT9GuP9auReqj\r\n" +
            "8Xirw42tcG4jiI0gPdsaziKnWrll1uiL9qD0Ee+827Sf+v3ShHqA93QkjOxK2iT2\r\n" +
            "nDa+MVp/D74D+42WAUBnNUy2oShSPq0NMstUiVR1mqydqELohq54uSD1wvVDOG/l\r\n" +
            "cf84HQE1AMTXGkIH0Fo30jmJaABGoc3Mse0XbgYGwQKBgQDNLsjac3u1Fe3kiMbO\r\n" +
            "1UXmEDCmt90LtP1u8e15/7re2Z/y7EfPNmsmcl0wL8Pk1d1z5hC8OyFCTT0dpoK4\r\n" +
            "9rfKstGH4mROHMkQT3k40vNUY0Q9P28LRiG2MN5+pdsBEauFFFFrxHnVB72q05z3\r\n" +
            "tg9O1lvvhv6BMjGmJtxDBpCP2wKBgQD7oxJO9r2Rd2URQOejezkYfPne+wrbGB42\r\n" +
            "PYwi8TYWZpgrAmgrBXgixdOg9A4Mpj+QkfjcDyerx2Sj4pGif5s3YF7H61nz3Hma\r\n" +
            "YgnuMnVaBJwoz5JRyX/y7PEN0QXufErNs8Qde9B9qczQypxRTwf/xN/QjTceIZFv\r\n" +
            "TmUJ5gFDoQKBgCl7pfwUkRRBhMFJrfgvQlyLNWrfjX9Kblq56utZeqyHj0EL6FDK\r\n" +
            "jctOH+0YGyDu5EEEaKnFwqmm+A5AlflTWEFQ+e/hI6pvQ29awgVtEOkk0K0ZYBgF\r\n" +
            "a9dr9e/hFHAY5HaZbwS8ymz5ja0172xdkKa9zASXZGk2frc68BlVAHE1AoGBAL5/\r\n" +
            "r4aUCOMtLhgnuLTsvkappkiGaKuA0K5jXcm+LiI7PQuiYNXg6Bf7B8GbwV8WJJz/\r\n" +
            "xRRjbLcA1lGzXmlUjV8Y1+glZg3VZUHY4oevL2QchVPoAG9mSjTP55V8Hi9zbPXZ\r\n" +
            "F6jyaN4ZQ/L0z+5GFFou4vlxTr7CzuUixh7+PwrBAoGBAIFA/uLEqrGYgkYSggKM\r\n" +
            "gNZy7HBbrKobyEtLiwrjTjMQnXDNPru3fAJ2CXE/CXskuOFrN8mzLiD5GXMgTNsU\r\n" +
            "sdDJiMoC3pJX6gNRiagZ8pZvurfe0oFGmKUQDhxLswo8ts5rZlR8u5fCJwectQOB\r\n" +
            "W6cazBQqrDiUKJ+6VWyW7vbH\r\n" +
            "-----END PRIVATE KEY-----";

    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAya+SZKZ1RiIVZsax9QQr\r\n" +
            "UJZ2z7UCySsI0GB/8bJ2IjOskuWAXoTyTdndiMud9L/LdlqwLpJPTMp5LSIpfUsR\r\n" +
            "+RsSiTeZltLuNits9kj2sZ1R9fLUDQzyklmcH7hlKJgGhrkUgVBre37WnpNwHpOr\r\n" +
            "jIkQZUVSqh/BvEk3Zz4KMB+evn3pCLXwKdjloJjx3L/BAjnYZqydgu6BhBadITLk\r\n" +
            "mFBGIgVIKavp8znerjnZXIdRIJ9MSTe8EF5Gi+kdkHVrV9Im1YLTgCdhJIcvRp4k\r\n" +
            "HElcEYTvcAqrmWf4dnuQ4i6q9jL2qlxlp6lFHMZ0EgtnOCZDB0h7tCnLz25hSGvJ\r\n" +
            "uwIDAQAB\r\n" +
            "-----END PUBLIC KEY-----";
}
